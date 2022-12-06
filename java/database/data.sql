INSERT INTO book (isbn13, title, pub_date, num_pages, language_id, overview ,CoverLink) 
VALUES (9780063270886, 'The Fellowship of the Ring','07/05/2022','432', 1, 'J.R.R. Tolkien’s classic fantasy has accumulated worldwide acclaim as the greatest adventure tale ever written. No other writer has created a world as distinct as Middle-earth, complete with its own geography, history, languages, and legends. And no one has created characters as endearing as Tolkien’s large-hearted, hairy-footed hobbits.',
		'https://prodimage.images-bn.com/lf?set=key%5Bresolve.pixelRatio%5D,value%5B1%5D&set=key%5Bresolve.width%5D,value%5B600%5D&set=key%5Bresolve.height%5D,value%5B10000%5D&set=key%5Bresolve.imageFit%5D,value%5Bcontainerwidth%5D&set=key%5Bresolve.allowImageUpscaling%5D,value%5B0%5D&set=key%5Bresolve.format%5D,value%5Bwebp%5D&source=url%5Bhttps://prodimage.images-bn.com/pimages/9780063270886_p0_v2_s600x595.jpg%5D&scale=options%5Blimit%5D,size%5B600x10000%5D&sink=format%5Bwebp%5D'),
		(9780063227262, 'Sira','09/13/2022','736', 3, 'Cuatro ciudades, dos misiones, una mujer. Vuelve a sumergirte en un tiempo inolvidable. Después de El tiempo entre costuras, SIRA, la nueva novela de María Dueñas.',
		 'https://prodimage.images-bn.com/pimages/9780063227262_p0_v2_s600x595.jpg'),
		(9781728281414, 'The Sun and Its Shade','02/28/2023', '544', 1, 'The novella features Zaccai, one of the Northern fae, and his complicated relationship with a mortal and another fae as the three train for the coming war with the queen. Exploring issues of identity, sexuality, power, and loyalty, Piper CJ brings strong writing and rich characters to expand her THE NIGHT AND ITS MOON world even further.',
		 'https://prodimage.images-bn.com/lf?set=key%5Bresolve.pixelRatio%5D,value%5B1%5D&set=key%5Bresolve.width%5D,value%5B300%5D&set=key%5Bresolve.height%5D,value%5B10000%5D&set=key%5Bresolve.imageFit%5D,value%5Bcontainerwidth%5D&set=key%5Bresolve.allowImageUpscaling%5D,value%5B0%5D&set=key%5Bresolve.format%5D,value%5Bwebp%5D&source=url%5Bhttps://prodimage.images-bn.com/pimages/9781728281414_p0_v1_s600x595.jpg%5D&scale=options%5Blimit%5D,size%5B300x10000%5D&sink=format%5Bwebp%5D');



INSERT INTO author (author_name) 
VALUES 	('J. R. R. Tolkien'),
		('María Dueñas'),
		( 'Piper CJ');


INSERT INTO book_author (isbn13, author_id) 
VALUES 	(9780063270886, 1),
		(9780063227262, 2),
		(9781728281414, 3);
		

INSERT INTO genre ( genre_name) 
VALUES 	( 'Action'),
		('Comedy'),
		('Drama'),
		('Fantasy'),
		('Horror'),
		('Mystery'),
		('Romance'),
		('Thriller');

INSERT INTO book_genre (isbn13, genre_id) 
VALUES 	(9780063270886, 4),
		(9780063227262, 4),
		(9781728281414, 4);
		
INSERT INTO publisher (publisher_name) 
VALUES 	('HarperCollins Publishing'),
		('Sourcebooks Publishing'),
		('Penguin Random House Grupo Editorial España');


INSERT INTO book_publisher (isbn13, publisher_id) 
VALUES 	(9780063270886, 1),
		(9780063227262, 2),
		(9781728281414, 3);

INSERT INTO book_language (language_name) 
VALUES 	('English'),
		('French'),
		('Spanish');


INSERT INTO book_tag (isbn13, tag_id) 
VALUES 	(9786070724145, 1),
		(9780063227262, 2),
		(9781728281414, 3);

INSERT INTO tag (tag_word) 
VALUES 	('Historical Fantasy'),
		('Libros y Libros para Niños '),
		('Fantasy - Women of Lore');




