INSERT INTO PapugUser (username, email, fullname, password, phoneNumber)
VALUES
  ('jan_kowalski', 'jan.kowalski@example.com', 'Jan Kowalski', 'hashed_password1', '123-456-7890'),
  ('anna_nowak', 'anna.nowak@example.com', 'Anna Nowak', 'hashed_password2', '987-654-3210'),
  ('piotr_wojcik', 'piotr.wojcik@example.com', 'Piotr Wójcik', 'hashed_password3', '555-123-4567'),
  ('katarzyna_kowalczyk', 'katarzyna.kowalczyk@example.com', 'Katarzyna Kowalczyk', 'hashed_password4', '111-222-3333'),
  ('andrzej_wozniak', 'andrzej.wozniak@example.com', 'Andrzej Woźniak', 'hashed_password5', '999-888-7777'),
  ('marek_kaminski', 'marek.kaminski@example.com', 'Marek Kamiński', 'hashed_password6', '444-555-6666'),
  ('agata_lewandowska', 'agata.lewandowska@example.com', 'Agata Lewandowska', 'hashed_password7', '777-111-2222'),
  ('paulina_jankowska', 'paulina.jankowska@example.com', 'Paulina Jankowska', 'hashed_password8', '333-999-4444'),
  ('jakub_swiderski', 'jakub.swiderski@example.com', 'Jakub Świderski', 'hashed_password9', '555-444-8888'),
  ('marta_witkowska', 'marta.witkowska@example.com', 'Marta Witkowska', 'hashed_password10', '666-777-5555')
ON CONFLICT (username) DO NOTHING;