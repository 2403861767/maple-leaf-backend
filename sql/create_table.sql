create table user
(
    id           bigint auto_increment comment 'id'
        primary key,
    username     varchar(256)                       null comment '昵称
',
    userAccount  varchar(256)                       null comment '登入账号
',
    gender       tinyint                            null comment '性别',
    avatarUrl    varchar(1024)                      null comment '用户头像
',
    userPassword varchar(512)                       not null comment '密码
',
    phone        varchar(128)                       null comment '电话
',
    email        varchar(512)                       null comment '邮箱',
    userStatus   int      default 0                 not null comment '表示用户状态
',
    createTime   datetime default CURRENT_TIMESTAMP null comment '创建时间',
    updateTime   datetime default CURRENT_TIMESTAMP null on update CURRENT_TIMESTAMP comment '更新时间',
    isDelete     tinyint  default 0                 not null comment '是否删除',
    userRole     int      default 0                 not null comment 'role表示用户身份,0表示普通用户,1表示管理员',
    planetCode   varchar(512)                       null comment '星球编号',
    tags         varchar(1024)                      null comment '标签列表'
)
    comment '用户表';