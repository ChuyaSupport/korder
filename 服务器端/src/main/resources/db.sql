create table t_post
(
    post_id      varchar(50)   null,
    user_id      varchar(50)   null,
    package_code varchar(50)   null,
    get_addr     varchar(255)  null,
    addr_id      varchar(50)   null,
    package_size varchar(10)   null,
    reward       varchar(20)   null,
    status       int default 0 null
);

create table t_receive
(
    receive_id varchar(255) null,
    post_id    varchar(50)  null,
    user_id    varchar(50)  null
);

create table t_user
(
    user_id      varchar(50)                   not null
        primary key,
    user_name    varchar(50)                   not null,
    avartar_url  varchar(255)                  not null,
    phone_number varchar(11)                   not null,
    password     varchar(50)                   not null,
    balance      decimal(10, 2) default (0.00) not null,
    gender       varchar(2)                    not null
);

create table t_address
(
    addr_id      varchar(50)  not null
        primary key,
    user_id      varchar(50)  null,
    user_name    varchar(50)  not null,
    gender       varchar(1)   not null,
    address      varchar(255) not null,
    phone_number varchar(11)  not null,
    constraint t_address_ibfk_1
        foreign key (user_id) references t_user (user_id)
);

create index user_id
    on t_address (user_id);

create definer = root@`%` view v_find_detail as
select `korder`.`t_post`.`get_addr`        AS `get_addr`,
       `korder`.`t_post`.`post_id`         AS `post_id`,
       `korder`.`t_post`.`reward`          AS `reward`,
       `korder`.`t_post`.`package_size`    AS `package_size`,
       `korder`.`t_post`.`package_code`    AS `package_code`,
       `korder`.`t_address`.`address`      AS `address`,
       `korder`.`t_address`.`user_name`    AS `user_name`,
       `korder`.`t_address`.`gender`       AS `gender`,
       `korder`.`t_address`.`phone_number` AS `phone_number`
from (`korder`.`t_post` left join `korder`.`t_address`
    on ((`korder`.`t_post`.`addr_id` = `korder`.`t_address`.`addr_id`)));

create definer = root@`%` view v_find_response as
select `korder`.`t_post`.`post_id`      AS `post_id`,
       `korder`.`t_post`.`get_addr`     AS `get_addr`,
       `korder`.`t_post`.`package_size` AS `package_size`,
       `korder`.`t_address`.`address`   AS `address`,
       `korder`.`t_post`.`reward`       AS `reward`
from (`korder`.`t_post` left join `korder`.`t_address`
    on ((`korder`.`t_post`.`addr_id` = `korder`.`t_address`.`addr_id`)))
where (`korder`.`t_post`.`status` = 0);

create definer = root@`%` view v_my_get as
select `korder`.`t_receive`.`user_id` AS `user_id`,
       `v_tmp`.`get_addr`             AS `get_addr`,
       `v_tmp`.`package_code`         AS `package_code`,
       `v_tmp`.`address`              AS `address`,
       `v_tmp`.`user_name`            AS `user_name`,
       `v_tmp`.`phone_number`         AS `phone_number`,
       `v_tmp`.`package_size`         AS `package_size`,
       `v_tmp`.`reward`               AS `reward`,
       `v_tmp`.`post_id`              AS `post_id`,
       `v_tmp`.`status`               AS `status`
from (`korder`.`t_receive` left join `korder`.`v_tmp` on ((`korder`.`t_receive`.`post_id` = `v_tmp`.`post_id`)));

create definer = root@`%` view v_my_post as
select `korder`.`t_post`.`get_addr`        AS `get_addr`,
       `korder`.`t_post`.`package_code`    AS `package_code`,
       `korder`.`t_post`.`package_size`    AS `package_size`,
       `korder`.`t_post`.`reward`          AS `reward`,
       `korder`.`t_post`.`status`          AS `status`,
       `korder`.`t_address`.`user_name`    AS `user_name`,
       `korder`.`t_address`.`address`      AS `address`,
       `korder`.`t_address`.`phone_number` AS `phone_number`,
       `korder`.`t_post`.`user_id`         AS `user_id`,
       `korder`.`t_post`.`post_id`         AS `post_id`
from (`korder`.`t_post` left join `korder`.`t_address`
    on ((`korder`.`t_post`.`addr_id` = `korder`.`t_address`.`addr_id`)));

create definer = root@`%` view v_tmp as
select `korder`.`t_post`.`get_addr`        AS `get_addr`,
       `korder`.`t_post`.`package_code`    AS `package_code`,
       `korder`.`t_address`.`address`      AS `address`,
       `korder`.`t_address`.`user_name`    AS `user_name`,
       `korder`.`t_address`.`phone_number` AS `phone_number`,
       `korder`.`t_post`.`package_size`    AS `package_size`,
       `korder`.`t_post`.`reward`          AS `reward`,
       `korder`.`t_post`.`post_id`         AS `post_id`,
       `korder`.`t_post`.`status`          AS `status`
from (`korder`.`t_post` left join `korder`.`t_address`
    on ((`korder`.`t_post`.`addr_id` = `korder`.`t_address`.`addr_id`)))
where `korder`.`t_post`.`post_id` in (select `korder`.`t_receive`.`post_id` from `korder`.`t_receive`);

