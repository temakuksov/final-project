CREATE EXTENSION IF NOT EXISTS pgcrypto;

INSERT INTO public.person (name, age, email, phonenumber, password, role, createdat, createdperson, removedat,
                           removedperson)
VALUES ('Admin', 23, 'admin1@mail.ru', '+79121234567', crypt('pwd', gen_salt('bf', 12)), 'admin', '2022-08-20 00:00:00.000000',
        'Admin', null, null);