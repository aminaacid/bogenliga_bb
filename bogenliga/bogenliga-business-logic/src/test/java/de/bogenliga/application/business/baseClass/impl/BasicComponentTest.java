package de.bogenliga.application.business.baseClass.impl;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import de.bogenliga.application.common.errorhandling.exception.BusinessException;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatExceptionOfType;

/**
 * TODO [AL] class documentation
 *
 * @author Andre Lehnert, eXXcellent solutions consulting & software gmbh
 */
public class BasicComponentTest<T, B> {
    private T expectedEntity;

    private Method method;


    public BasicComponentTest(T expectedEntity) {
        this.expectedEntity = expectedEntity;
    }


    /**
     * Tests create method of componentImpl
     */
    public B testCreateMethod(
            B entityDO) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        method = expectedEntity.getClass().getDeclaredMethod("create", entityDO.getClass(), Long.class);
        return testCreationMethods(entityDO);
    }


    /**
     * Tests update method of componentImpl
     */
    public B testUpdateMethod(
            B entityDO) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        method = expectedEntity.getClass().getDeclaredMethod("update", entityDO.getClass(), Long.class);
        return testCreationMethods(entityDO);
    }


    public void testDeleteMethod(
            B entityDO) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        method = expectedEntity.getClass().getDeclaredMethod("delete", entityDO.getClass(), Long.class);
        testCreationMethods(entityDO);
        testUpdateMethods(entityDO);
    }


    private B testCreationMethods(B entityDO) throws InvocationTargetException, IllegalAccessException {
        B be = (B) method.invoke(expectedEntity, entityDO, 1L);
        testUpdateMethods(entityDO);
        return be;
    }


    private void testUpdateMethods(B entityDO) throws IllegalAccessException {
        Object[] param = new Object[]{entityDO, -1L};
        assertExceptionBadInput(1, param);
        param = new Object[]{entityDO, null};
        assertExceptionBadInput(1, param);
    }


    /**
     * checks all find methods of the entity given in the construtor checks each parameter if it throws a business
     * exception on negative parameter or Null parameter
     *
     * @throws IllegalAccessException
     */
    public void assertException() throws IllegalAccessException {

        for (Method method : expectedEntity.getClass().getDeclaredMethods()) {
            if (method.getName().contains("find")) {
                this.method = method;
                int count = method.getParameterCount();
                // cant test parameters of methods without params
                if (count != 0) {
                    Long[] arr = new Long[count];
                    Arrays.fill(arr, 1L); //fills the array with Ones
                    assertExceptionPerMethod(arr);
                }
            }
        }
    }


    /**
     * Tests each single parameter if it throws the needed exception on negative and null
     *
     * @param value parameters for the method
     */
    private void assertExceptionPerMethod(Long... value) throws IllegalAccessException {
        for (int i = 0; i < value.length; i++) {
            //check for negative Precondition
            value[i] = -1L;
            assertExceptionBadInput(i, value);
            //check for null Precondition
            value[i] = null;
            assertExceptionBadInput(i, value);
            // set back to normal
            value[i] = 1L;
        }
    }


    /**
     * This tests if exceptions are thrown by component classes
     *
     * @param value the params which differ for each method
     */
    private void assertExceptionBadInput(int i, Object... value) throws IllegalAccessException {
        assertThatExceptionOfType(InvocationTargetException.class)
                .isThrownBy(() -> method.invoke(expectedEntity, value))
                .withCauseInstanceOf(BusinessException.class);

        /**checking if the cause message is correct
         * because you can't check the message of the cause with the assertThatExceptionOfType method
         * Once for parameter negative and once for null
         */
        if (value[i] != null) {
            try {
                method.invoke(expectedEntity, value);
                //Should not be reachable assert
                assertThat(1).isEqualTo(0);
            } catch (InvocationTargetException e) {
                assertThat(e.getCause()).hasMessageContaining("not be negative");
            }
        } else {
            try {
                method.invoke(expectedEntity, value);
                //Should not be reachable assert
                assertThat(1).isEqualTo(0);
            } catch (InvocationTargetException e) {
                assertThat(e.getCause()).hasMessageContaining("not be null");
            }
        }
    }
}
