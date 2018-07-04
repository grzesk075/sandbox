-- Test1.sql
-- Autor grzesk.
-- Relacja wiążąca dwie tabele jest określona przez klucz obcy.
-- Poziom trudności rośnie wraz z numerem zadania.
-- 1. Napisać zapytanie, które wypisze posortowane rosnąco identyfikatory z tabeli TOutageRecord
--    dla wierszy, które mają m_Type równy 3 albo 5 i nie ustawione pola z czasem.
-- 2. Co wiadomo o liczbie wierszy w tabeli TOutageRecord, gdy w tabeli TOutageStep jest 5 wierszy?
-- 3. Napisać zapytanie, które wypisze wiersze zawierające identyfikatory powiązanych rekordów z obu tabel.
-- 4. Napisać zapytanie, które wypisze w wierszu identyfikatory z tabeli TOutageRecord, liczbę powiązanych rekordów
--    w TOutageStep i sumę ich m_CustomerCount.
-- 5. Napisać zapytanie, które wypisze identyfikatory z tabeli TOutageRecord, które nie mają powiązanych rekordów w TOutageStep.
-- 6. Napisać zapytanie, które wypisze w wierszu identyfikatory z tabeli TOutageRecord i sumę energii powiązanych rekordów
--    obliczoną z 'czasu trwania' TOutageStep i ich 'mocy', posortowane od największej energii.
--    Odfiltrować wyniki o energii mniejszej niż 1MWh.

create table meas.TOutageRecord
(
m_Id                        integer not null primary key,
m_Type                      integer,
m_CustomerCount             integer,
m_BeginTime                 timestamp,
m_EndTime                   timestamp,
m_Info                      varchar2( 250)
) tablespace exauto;

create table meas.TOutageStep
(
m_Id                        integer not null primary key,
m_TOutageRecord             integer not null,
m_BeginTime                 timestamp,
m_EndTime                   timestamp,
m_CustomerCount             integer,
m_Power                     number
) tablespace exauto;

alter table meas.TOutageStep add foreign key( m_TOutageRecord) references meas.TOutageRecord( m_Id);