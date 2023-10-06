/* Insertion des catégories */
INSERT INTO `category` (`name`)
    VALUES  ('Policier'),
            ('Science fiction'),
            ('Littérature française'),
            ('Littérature internationale'),
            ('Poésie');

/* Insertion de livres pour tests */
INSERT INTO `book` (`title`, `author`, `total_items`, `remaining_items`, `category_id`)
    VALUES  ('Substance Mort', ' K.Dick, Philip', 3, 1, 2),
            ('Le Chat', 'Simenon, Georges', 5, 2, 3),
            ('Les Miserables vol-1', 'Hugo, Victor', 1, 1, 5),
            ('Christine', 'King, Stephen', 1, 0, 4),
            ('Dune', 'Herbert, Franck', 6, 4, 5),
            ('500 000 Dollars', 'Hemingway, Ernest', 3, 2, 2),
            ('La Horde Du Hurlevent', 'Damazio, Alain', 4, 4, 3),
            ('Au Dela du Mal', 'Stevens, Shane', 8, 3, 5),
            ('Le Mambo des Deux ours', 'Lonsdale, Joe R.', 1, 0, 4),
            ('Sido', 'Colette', 6, 4, 5),
            ('Sutree', 'MC Carthy, Cormack', 3, 2, 2),
            ('Le Silmarillon', 'Tolkien, J.R.R.', 4, 4, 3),
            ('Le Feu', 'Barbusse, Henry', 8, 3, 5);

/* Insertion des roles */
INSERT INTO `role` (`name`)
VALUES  ('ROLE_USER'),
        ('ROLE_MODERATOR'),
        ('ROLE_ADMIN');

/* Insertion d'utilisateurs pour tests */
INSERT INTO `user` (`username`, `lastname`, `firstname`, `password`, `email`, `email_verified`, `can_borrow`, `penalty_amount`, `role_id`)
    VALUES  ('Vince', 'Faure', 'Vincent', 'password', 'vince@vince.faure', true, true, 0, 1),
            ('Elsa', 'Faure', 'Elsa', 'password', 'elsa@elsa.faure', true, false, 0, 1),
            ('Cliff', 'Burton', 'Cliff', 'password', 'cliff@megafoce.', true, false, 5.5, 1),
            ('Bon', 'Scott', 'Bon', 'password', 'bon@acdc.aus', true, true, 0, 1),




/* Insertion d'emprunts pour tests */
INSERT INTO `loan` (`borrowed_at`, `return_date`, `returned_at`, `book_id`, `user_id`)
    VALUES  ('2023-08-18 11:05:15', null, null, 2, 4),
            ('2023-08-22 12:06:35', null, null, 1, 6),
            ('2023-07-31 09:52:35', null, null, 5, 3);

INSERT INTO `loan` (`book_id`, `user_id`)
    VALUES  (2, 10),
            (1, 12),
            (4, 14),
            (9, 15),
            (4, 17),
            (6, 9);
