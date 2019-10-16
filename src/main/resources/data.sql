INSERT INTO `food_item` (id, description, name, price)
VALUES (1, 'God flæsk', 'Flæskesteg', 50),
       (2, 'Sprød and', 'And', 100),
       (3, 'Tyk sovs', 'Brun sovs', 20),
       (4, 'Sukkerkartofler', 'Brune kartofler', 30),
       (5, 'Dansk produceret', 'Rødkål', 15);

INSERT INTO `menu` (id, description, name, price)
VALUES (1, 'Billig men god menu', 'Billig menu', 250),
       (2, 'Luksus menu', 'Luksus julemenu', 500);

INSERT INTO `menu_food_item` (menu_id, food_item_id)
VALUES (1, 1),
       (1, 3),
       (1, 4),
       (1, 5),
       (2, 1),
       (2, 2),
       (2, 3),
       (2, 4),
       (2, 5);

INSERT INTO `customer_order` (id, customer_address, customer_comment, customer_email, customer_name,
                              customer_phone_number, delivery_date, guest_count, order_date, price_total,
                              menu_id )
VALUES (1, 'Lygten 16 2000 København', 'Bank på døren', 'keaconnet@kea.dk',
        'Benny Jørgensen', '57450830', '2018-12-20 12:45:00', 15, '2018-11-06 11:12:13', 1000.00, 1),
       (2, 'Torpegårdsvej 7 9740 Jerslev J', '', 'AndreasCVestergaard@jourrapide.com',
        'Andreas C. Vestergaard', '29590560', '2018-05-14 16:30:00', 20, '2018-05-02 17:42:01', 520.00, 2),
       (3, 'Hersnapvej 61 1074 København K', 'Ingen nøder tak', 'NicolineHCarlsen@jourrapide.com',
        'Nicoline H. Carlsen', '21963410', '2018-04-07 13:00:00', 13, '2018-03-17 10:20:36', 325.00, 1),
       (4, 'Frørup Byvej 4 1171 København K', 'Gennem den røde dør', 'AnnemetteBAndreasen@armyspy.com',
        'Annemette B. Andreasen', '27215470', '2018-12-28 18:25:00', 7, '2018-12-13 06:30:26', 837.00, 2);