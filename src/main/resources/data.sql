INSERT INTO papug_user (username, email, fullname, password, phone_number, account_type)
VALUES
  ('admin', 'mark.admin@example.com', 'Mark Admin', 'hashed_password0', '111-222-3333', 'SUPERADMIN'),
  ('jan_kowalski', 'jan.kowalski@example.com', 'Jan Kowalski', 'hashed_password1', '123-456-7890', 'REGULAR'),
  ('anna_nowak', 'anna.nowak@example.com', 'Anna Nowak', 'hashed_password2', '987-654-3210', 'REGULAR'),
  ('piotr_wojcik', 'piotr.wojcik@example.com', 'Piotr Wójcik', 'hashed_password3', '555-123-4567', 'REGULAR'),
  ('katarzyna_kowalczyk', 'katarzyna.kowalczyk@example.com', 'Katarzyna Kowalczyk', 'hashed_password4', '111-222-3333', 'REGULAR'),
  ('andrzej_wozniak', 'andrzej.wozniak@example.com', 'Andrzej Woźniak', 'hashed_password5', '999-888-7777', 'REGULAR'),
  ('marek_kaminski', 'marek.kaminski@example.com', 'Marek Kamiński', 'hashed_password6', '444-555-6666', 'REGULAR'),
  ('agata_lewandowska', 'agata.lewandowska@example.com', 'Agata Lewandowska', 'hashed_password7', '777-111-2222', 'REGULAR'),
  ('paulina_jankowska', 'paulina.jankowska@example.com', 'Paulina Jankowska', 'hashed_password8', '333-999-4444', 'REGULAR'),
  ('jakub_swiderski', 'jakub.swiderski@example.com', 'Jakub Świderski', 'hashed_password9', '555-444-8888', 'REGULAR'),
  ('marta_witkowska', 'marta.witkowska@example.com', 'Marta Witkowska', 'hashed_password10', '666-777-5555', 'REGULAR')
ON CONFLICT (username) DO NOTHING;