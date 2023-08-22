/* Insertion des catégories */
INSERT INTO `category` (`name`)
    VALUES  ('Policier'),
            ('Science fiction'),
            ('Littérature française'),
            ('Littérature internationale'),
            ('Poésie');

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

/* Insertion des roles */
INSERT INTO `role` (`name`)
VALUES  ('ROLE_USER'),
        ('ROLE_MODERATOR'),
        ('ROLE_ADMIN');

/* Insertion d'utilisateurs pour tests */
INSERT INTO `user` (`username`, `lastname`, `firstname`, `password`, `email`, `email_verified`, `can_borrow`, `penalty_amount`, `role_id`)
    VALUES  ('Gil', 'TEIGNE', 'Gilles', 'graboulli', 'gilles.t@test.fr', true, true, 0, 1),
            ('Dav', 'HAURY', 'David', 'digachou', 'david.h@test.com', false, false, 0, 1),
            ('Line', 'TAIG', 'Caroline', '18c02t', 'caro.t@test.orgg', true, false, 5.5, 1),
            ('Mymy', 'GUAN', 'Michel', 'juerghte', 'mymy@test.mag', false, true, 0, 1),
            ('Fred', 'TANG', 'Frederic', 'klertagi', 'fred.t@test.ue',  true, true, 0, 2),
            ('Julieg', 'GASTON', 'Julie', 'tagadaJG', 'julie.g@test.wor', true, false, 0, 2);



/* Insertion d'emprunts pour tests */
INSERT INTO `loan` (`borrowed_at`, `return_date`, `returned_at`, `book_id`, `user_id`)
    VALUES  ('', '', '', 2, 4),
            ('', '', '', 1, 6),
            ('', '', '', 5, 9);
