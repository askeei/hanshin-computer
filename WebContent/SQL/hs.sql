drop database if exists hanshin;
create database hanshin;
use hanshin;

drop table if exists member;
create table member(
   id varchar(20) NOT NULL,
   pw text DEFAULT NULL,
   name varchar(20) DEFAULT NULL,
   sex varchar(10) DEFAULT NULL,
   phone varchar(20) DEFAULT NULL,
   type int DEFAULT '0',
   primary key(id)
);
insert into member
values("inside94", "4c4ea1e248d127717679862f032dce8e6dd5e749c7f1342c0668da9017f225bc", "�ȼ���", "��", "010-0000-0000", 1);
insert into member
values("lee95", "69abe0f33373fb8726da459b638dd43408e7bd26dd42e8d4b179602bf9c3e5c8", "�迹��", "��", "010-1111-1111", 1);
insert into member
values("door97", "3b6e0313282df012397bdd86ee181f55a4aa1ed73fc5ef7b54ec05b5b57d89b8", "������", "��", "010-2222-2222", 0);
insert into member
values("jeong96", "05f19c16d9265110cfd2d4c0fd1ec0e912a248b1da8010241369370d8829cd30", "������", "��", "010-3333-3333", 0);
insert into member
values("root", "74b61d2b8725cdbef63bbfff86c5bb428d91d80fb268e0969f71ad210d74fcef", "�ý��۰�����", "", "", 2);


drop table if exists performance;
create table performance(
   name varchar(50) NOT NULL,
   type varchar(10) DEFAULT NULL,
   time int DEFAULT '0',
   id varchar(20) NOT NULL,
   primary key(name)
);


insert into performance
values("[�������湮] ���ڳ� �������θ�Ʈ(�������� ü���)", "test", 0, "inside94");
insert into performance
values("[����] 2019 ���� ���п� ��(��)�Ի� ����", "test", 0, "inside94");
insert into performance
values("[����] û�� TLO ������� ����ȸ", "test", 0, "inside94");
insert into performance
values("[����Ʈ���� ������] 18�⵵ ��ǻ�Ͱ��к� 24ȸ ����Ʈ���� ������ �ȳ�", "test", 0, "lee95");
insert into performance
values("[������] â���� ���ռ��� ������ȸ �ȳ�", "test", 0, "lee95");

drop table if exists performance_stage;
create table performance_stage(
   place varchar(20) NOT NULL,
   seatOfR int DEFAULT '0',
   seatOfS int DEFAULT '0',
   seatOfA int DEFAULT '0',
   primary key(place)
);
insert into performance_stage
values("test1", 3, 4, 6);
insert into performance_stage
values("test2", 5, 5, 7);
insert into performance_stage
values("test3", 4, 5, 5);
insert into performance_stage
values("test4", 4, 3, 3);

drop table if exists open_performance;
create table open_performance(
   pno int NOT NULL AUTO_INCREMENT,
   name varchar(50) DEFAULT NULL,
   place varchar(20) DEFAULT NULL,
   sdate date DEFAULT NULL,
   edate date DEFAULT NULL,
   stime varchar(20) DEFAULT NULL,
   priceSeatR int DEFAULT '0',
   priceSeatS int DEFAULT '0',
   priceSeatA int DEFAULT '0',
   id varchar(20) NOT NULL,
   opened int DEFAULT '0',
   primary key(pno)
);
insert into open_performance (name, place, sdate, edate, stime, priceSeatR, priceSeatS, priceSeatA, id, opened)
values("[�������湮] ���ڳ� �������θ�Ʈ(�������� ü���)", "test", "2018-06-18", "2018-06-19", "20:00", 70000, 50000, 30000, "inside94", 1);
insert into open_performance (name, place, sdate, edate, stime, priceSeatR, priceSeatS, priceSeatA, id, opened)
values("[����] 2019 ���� ���п� ��(��)�Ի� ����", "test", "2018-06-15", "18-06-16", "19:00", 80000, 60000, 30000, "inside94", 1);
insert into open_performance (name, place, sdate, edate, stime, priceSeatR, priceSeatS, priceSeatA, id, opened)
values("[����] û�� TLO ������� ����ȸ", "test", "2018-06-27", "18-06-27", "14:00", 30000, 30000, 30000, "inside94", 1);
insert into open_performance (name, place, sdate, edate, stime, priceSeatR, priceSeatS, priceSeatA, id, opened)
values("[����Ʈ���� ������] 18�⵵ ��ǻ�Ͱ��к� 24ȸ ����Ʈ���� ������ �ȳ�", "test", "2018-06-10", "2018-06-15", "19:30", 380000, 280000, 150000, "lee95", 1);
insert into open_performance (name, place, sdate, edate, stime, priceSeatR, priceSeatS, priceSeatA, id)
values("[������] â���� ���ռ��� ������ȸ �ȳ�", "test", "2018-06-22", "2018-07-15", "19:00", 50000, 35000, 20000, "lee95");


drop table if exists exhibition;
create table exhibition(
   name varchar(50) NOT NULL,
   genre varchar(20) DEFAULT NULL,
   sponsor varchar(20) DEFAULT NULL,
   id varchar(20) NOT NULL,
   primary key(name)
);
insert into exhibition
values("[ä��] NCS��� ä�� ���빮�� ���ð��� ���� ���� ä��", "ä��", "ä������", "inside94");
insert into exhibition
values("[����] ���� �д� å ��� ���������? �ѱ����Ǽ����̽�!", "����", "���������", "inside94");
insert into exhibition
values("[ȫ��] ��ġ�� 4�� ������� �о��� �����ɷ� ��� ���� �¶��� ���α׷� ������ ����", "ȫ��", "ȫ�������", "lee95");
insert into exhibition
values("[ȫ��] KOHI �������¼��̳� �����Ƿ� û����� ���� �۷ι� ��� ���� (11/3)", "ȫ��", "ȫ�������", "lee95");

drop table if exists exhibition_stage;
create table exhibition_stage(
   place varchar(20) NOT NULL,
   closure date DEFAULT NULL,
   primary key(place)
);
insert into exhibition_stage
values("test1", "2018-10-01");
insert into exhibition_stage
values("test2",  "2018-10-01");
insert into exhibition_stage
values("test3",  "2018-10-01");

drop table if exists open_exhibition;
create table open_exhibition(
   eno int NOT NULL AUTO_INCREMENT,
   name varchar(50) DEFAULT NULL,
   place varchar(20) DEFAULT NULL,
   sdate date DEFAULT NULL,
   edate date DEFAULT NULL,
   price int DEFAULT '0',
   id varchar(20) DEFAULT NULL,
   opened int DEFAULT '0',
   primary key(eno)
);
insert into open_exhibition (name, place, sdate, edate, price, id)
values("[ä��] NCS��� ä�� ���빮�� ���ð��� ���� ���� ä��", "test1", "2018-06-13", "2018-06-20", 0, "inside94");
insert into open_exhibition (name, place, sdate, edate, price, id, opened)
values("[����] ���� �д� å ��� ���������? �ѱ����Ǽ����̽�!", "test2", "2018-05-31", "2018-06-18", 10000, "inside94", 1);
insert into open_exhibition (name, place, sdate, edate, price, id,opened)
values("[ȫ��] ��ġ�� 4�� ������� �о��� �����ɷ� ��� ���� �¶��� ���α׷� ������ ����", "test3", "2018-06-29", "2018-07-08", 0, "lee95",2);
insert into open_exhibition (name, place, sdate, edate, price, id, opened)
values("[ȫ��] KOHI �������¼��̳� �����Ƿ� û����� ���� �۷ι� ��� ���� (11/3)", "test3", "2018-06-06", "2018-07-08", 5000, "lee95", 1);

