/*
    drop table if exists demo
	create table demo(
	id int primary key,
	name varchar(255) NOT NULL
	);
*/

-- Modified demo SQL for: formatting, extending the max length of a palindrome, and resetting the sequence.

drop table if exists palindrome;
create table palindrome(
id Long primary key,
palindrome varchar NOT NULL
);
ALTER SEQUENCE HIBERNATE_SEQUENCE 0;