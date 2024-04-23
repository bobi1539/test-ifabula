-- dummy book
INSERT INTO public.m_book
(id, created_at, is_deleted, updated_at, description, is_borrow, title)
VALUES(1, '2024-04-23 20:41:55.538', false, '2024-04-23 21:16:17.833', 'Buku 1 Deskripsi', false, 'Buku 1');
INSERT INTO public.m_book
(id, created_at, is_deleted, updated_at, description, is_borrow, title)
VALUES(2, '2024-04-23 20:42:00.344', false, '2024-04-23 21:16:23.843', 'Buku 2 Deskripsi', true, 'Buku 2');


-- dummy user
INSERT INTO public.m_user
(id, created_at, is_deleted, updated_at, account_type, email, "password")
VALUES(1, '2024-04-23 20:42:25.237', false, '2024-04-23 20:42:25.237', 'customer', 'ucup@gmail.com', '$2a$10$3yXrvN9ecVPkHPUR3BomE.1vFfJxExFfaqwcDJvHPGuirp4kLYeoO');
INSERT INTO public.m_user
(id, created_at, is_deleted, updated_at, account_type, email, "password")
VALUES(2, '2024-04-23 20:42:25.237', false, '2024-04-23 20:42:25.237', 'admin', 'admin@gmail.com', '$2a$12$pG1kbOhbHd.M5DABk.YV2OyvM3UetWi9sGo86PKGipRwP49Aqrc3e');


-- dummy borrow book
INSERT INTO public.t_borrow_book
(id, created_at, is_deleted, updated_at, actual_return_date, borrow_date, is_return, return_date, book_id, user_id)
VALUES(1, '2024-04-23 20:42:38.835', false, '2024-04-23 21:16:17.853', '2024-04-23 21:16:17.829', '2024-04-23 20:42:38.831', true, '2024-04-24 07:00:00.000', 1, 1);
INSERT INTO public.t_borrow_book
(id, created_at, is_deleted, updated_at, actual_return_date, borrow_date, is_return, return_date, book_id, user_id)
VALUES(3, '2024-04-23 21:16:23.835', false, '2024-04-23 21:16:23.835', NULL, '2024-04-23 21:16:23.834', false, '2024-04-25 07:00:00.000', 2, 1);
