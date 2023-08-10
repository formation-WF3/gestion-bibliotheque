/* Insertion des catégories */
INSERT INTO `category` (`name`)
    VALUES  ('POLICIER'),
            ('SCIENCE_FICTION'),
            ('LITTERATURE_FRANCAISE'),
            ('LITTERATURE_INTERNATIONALE'),
            ('POESIE');

/* Insertion de livres pour tests */
INSERT INTO `book` (`title`, `author`, `total_items`, `remaining_items`, `category_id`)
    VALUES  ('Le mage', 'Raymond E.FEIST', 3, 1, 2),
            ('C\'est pas ma faute', 'Mr TAN', 5, 2, 3),
            ('Rufus va à l\'école', 'V. GORBACHEV', 1, 1, 5),
            ('Tom-Tom et Nana', 'Caroline MAYARD', 1, 0, 4),
            ('Les super histoires des filles', 'Fred MULTIER', 6, 4, 5),
            ('Créer un site Web pour les nuls', 'David CROWLER', 3, 2, 2),
            ('300 Recettes pour la machine à pain', 'Cécile LE HINGRAT', 4, 4, 3),
            ('Au secours des ours polaires', 'Nickelodeon', 8, 3, 5);
