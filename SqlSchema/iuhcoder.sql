CREATE TABLE user_profile(
	id int primary key,
	username varchar(200) not null,
	password varchar(300) not null,
	full_name varchar(500) null,
	level int null,
	status int null,
	constraint id_UNIQUE
		unique (id)
);
INSERT INTO user_profile(id, username, password, full_name, level, status)
VALUES (1, 'iuh_master', 'username', 'Trần Như Thế', 5, 1);
INSERT INTO user_profile(id, username, password, full_name, level, status)
VALUES (2, 'tester', 'noname', 'Vũ Thanh Hải', 2, 1);
INSERT INTO user_profile(id, username, password, full_name, level, status)
VALUES (3, 'developer', 'onlyme', 'Nguyen Duy Tien', 3, 0);
INSERT INTO user_profile(id, username, password, full_name, level, status)
VALUES (4, 'devops', 'oooppp', 'Kibana El', 4, 1);

CREATE TABLE submission
(
	id int primary key,
	problem_id varchar(45) null,
	problem_name varchar(45) null,
	score varchar(45) null,
	status varchar(45) null,
	source_code text null,
	uid int null,
	constraint fk_submission_user
		foreign key (uid) references user_profile (id)
);

INSERT INTO submission(id,problem_id,problem_name,score,status,source_code,uid)
VALUES (2, '1', 'Easy', '50', '1', '#include <iostream>

using namespace std;

int main(){
    cout>>"Hello world";

}', 2);
INSERT INTO submission(id,problem_id,problem_name,score,status,source_code,uid)
VALUES (3, '2', 'WTF', '200', '1', '#include <iostream>

using namespace std;

int main(){
    cout>>"Hello Chicken";

}', 3);













