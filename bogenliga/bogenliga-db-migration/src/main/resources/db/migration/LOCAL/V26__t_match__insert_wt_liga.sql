INSERT INTO match (
  match_nr,
  match_wettkampf_id,
  match_begegnung,
  match_mannschaft_id,
  match_scheibennummer,
  match_matchpunkte,
  match_satzpunkte)
VALUES
  (1, 30, 1, 101, 1, 2, 6),
  (1, 30, 1, 102, 2, 0, 2),
  (1, 30, 2, 103, 3, 2, 6),
  (1, 30, 2, 104, 4, 0, 4),
  (1, 30, 3, 105, 5, 2, 6),
  (1, 30, 3, 106, 6, 0, 2),
  (1, 30, 4, 107, 7, 2, 7),
  (1, 30, 4, 108, 8, 0, 1),
  (2, 30, 1, 102, 1, 2, 6),
  (2, 30, 1, 107, 2, 0, 4),
  (2, 30, 2, 106, 3, 2, 6),
  (2, 30, 2, 101, 4, 0, 4),
  (2, 30, 3, 105, 5, 2, 6),
  (2, 30, 3, 103, 6, 0, 2),
  (2, 30, 4, 108, 7, 2, 7),
  (2, 30, 4, 104, 8, 0, 3),
  (3, 30, 1, 101, 1, NULL, NULL),
  (3, 30, 1, 103, 2, NULL, NULL),
  (3, 30, 2, 104, 3, NULL, NULL),
  (3, 30, 2, 102, 4, NULL, NULL),
  (3, 30, 3, 108, 5, NULL, NULL),
  (3, 30, 3, 105, 6, NULL, NULL),
  (3, 30, 4, 107, 7, NULL, NULL),
  (3, 30, 4, 106, 8, NULL, NULL),
  (4, 30, 1, 102, 1, NULL, NULL),
  (4, 30, 1, 105, 2, NULL, NULL),
  (4, 30, 2, 106, 3, NULL, NULL),
  (4, 30, 2, 104, 4, NULL, NULL),
  (4, 30, 3, 108, 5, NULL, NULL),
  (4, 30, 3, 101, 6, NULL, NULL),
  (4, 30, 4, 107, 7, NULL, NULL),
  (4, 30, 4, 103, 8, NULL, NULL)
;

