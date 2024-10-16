DROP TABLE IF EXISTS `bm`;
CREATE TABLE `bm` (
  `id` char(32) CHARACTER SET utf8 NOT NULL DEFAULT '' COMMENT 'id',
  `bh` char(4) CHARACTER SET utf8 NOT NULL DEFAULT '' COMMENT '编号',
  `mc` varchar(20) CHARACTER SET utf8 DEFAULT NULL COMMENT '名称',
  `dh` varchar(20) CHARACTER SET utf8 DEFAULT NULL COMMENT '电话',
  `cz` varchar(20) CHARACTER SET utf8 DEFAULT NULL COMMENT '传真',
  `clrq` char(10) CHARACTER SET utf8 DEFAULT NULL COMMENT '成立日期，格式2020-01-01',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='部门信息表';

#
# Data for table "bm"
#

INSERT INTO `bm` VALUES ('4150aa673b2c4c0abd23b337cb01b874','BM04','法务部','88880004','66660004','2020-01-01'),('7b08eb003c474147a7d762ad5fb15246','BM02','人事行政部','88880002','66660002','2020-01-01'),('880fc4a8a7374ce99ade9b0f38477bd6','BM03','财务部','88880003','66660003','2020-01-01'),('a1cb99d12dd34906ac2500f86b015b2b','BM05','产品技术部','88880005','66660005','2020-01-01'),('b50fb65031644b36ab930928c2984f61','BM01','总经理办公室','88880001','66660001','2020-01-01'),('bf47b6669c06459c966e2e7e359ff570','BM07','销售部','88880007','66660007','2020-01-01'),('fe9a965ecb634868ad288b8c7b2d4889','BM06','运营部','88880006','66660006','2020-01-01');

#
# Structure for table "gly"
#

-- auto-generated definition
create table gly
(
    id    char(32) charset utf8mb3    default '' not null comment 'id'
        primary key,
    zhm   varchar(20) charset utf8mb3 default '' not null comment '账户名',
    mm    varchar(20) charset utf8mb3 default '' not null comment '密码',
    nc    varchar(20) charset utf8mb3 default '' not null comment '昵称',
    glylx char(1)  default '1' not null comment '管理员类型，1:普通管理员, 2:超级管理员'
)
    comment '管理员信息表' collate = utf8mb3_bin;

#
# Data for table "gly"
#

INSERT INTO `gly` (id, zhm, mm, nc)
VALUES
    ('0f8ec71d868040d191fa323d5ffe31c0','zhangsan','111111','winter'),
    ('d3844cdb2eb04dce870d2a0b5973b862','admin','123456','summer');

#
# Structure for table "gw"
#

DROP TABLE IF EXISTS `gw`;
CREATE TABLE `gw` (
  `id` char(32) CHARACTER SET utf8 NOT NULL DEFAULT '' COMMENT 'id',
  `bh` char(5) CHARACTER SET utf8 NOT NULL DEFAULT '' COMMENT '编号',
  `mc` varchar(20) CHARACTER SET utf8 DEFAULT NULL COMMENT '名称',
  `lx` char(1) CHARACTER SET utf8 DEFAULT NULL COMMENT '类型，分为：1经理、2主管、3专员',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='岗位信息表';

#
# Data for table "gw"
#

INSERT INTO `gw` VALUES ('00206046f839450bb7667e87767c98aa','GW015','产品主管','2'),('0b7c3bd94fc14e169ebe0d9a4bb72cbf','GW013','法务专员','3'),('0fc11ca58a464fa18da21d8b888f3518','GW020','运营主管','2'),('19cc718cac6346bf84ee7b70830af0e6','GW016','技术主管','2'),('28d5750b21564ab7aae8d7adf543358d','GW018','技术专员','3'),('2a356d766c114505857a9351bb318ed3','GW003','人事行政经理','1'),('323ff2f7164247288fe8e4955eb47c86','GW004','人事主管','2'),('6712b70b014d473e9b704afba58057b1','GW021','运营专员','3'),('747dcf1ffd5741b88a02051e5ec0c499','GW014','产品技术经理','1'),('80301b0e050548839758a90bdbcb0396','GW010','财务专员','3'),('844f01e229344c0fb12904ff58d52cce','GW022','销售经理','1'),('854037193c3e4e41a1d70ba05bbf7eb2','GW019','运营经理','1'),('8f1797eec70d42b3b0781fd83905f3a6','GW006','人事专员','3'),('a78a5e0597cc437bbd07b78570f13272','GW011','法务经理','1'),('aa71e7226366410eafea3560b64f1eb2','GW007','行政专员','3'),('abedfcc6cc6d497db33b2ae4f6e207a0','GW008','财务经理','1'),('afb5487739e6421a8ed4816837428dd1','GW002','总经理助理','3'),('b12e641b718048bd8e748b764e3e6033','GW017','产品专员','3'),('b28e9d31858c49929a8bfe27157884fc','GW005','行政主管','2'),('b69418e78da54abea68f6b72a3aed0fc','GW009','财务主管','2'),('c647da356c684f7aad581492fa5c6347','GW012','法务主管','2'),('e163b9964b154e7e94baa3743a7ca60f','GW001','总经理','1'),('f9d2dea5ae4f492ea95c1bee4b8ff27a','GW023','销售主管','2');

#
# Structure for table "lz"
#

DROP TABLE IF EXISTS `lz`;
CREATE TABLE `lz` (
  `id` char(32) CHARACTER SET utf8 NOT NULL DEFAULT '' COMMENT 'id',
  `ygid` char(32) CHARACTER SET utf8 NOT NULL DEFAULT '' COMMENT '员工id',
  `lzrq` char(10) CHARACTER SET utf8 DEFAULT NULL COMMENT '离职日期，格式2024-05-01',
  `lzlx` char(1) CHARACTER SET utf8 DEFAULT NULL COMMENT '离职类型：1主动辞职、2辞退、3退休、4开除、5试用期未通过',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='员工离职信息表';

#
# Data for table "lz"
#

INSERT INTO `lz` VALUES ('04283b3860c94b2596503a484ae34154','836f5e22ca7d4e2294abbacfaf2f789e','2024-05-01','1');

#
# Structure for table "sy"
#

DROP TABLE IF EXISTS `sy`;
CREATE TABLE `sy` (
  `id` char(32) CHARACTER SET utf8 NOT NULL DEFAULT '' COMMENT 'id',
  `ygid` char(32) CHARACTER SET utf8 NOT NULL DEFAULT '' COMMENT '员工id',
  `zt` char(1) CHARACTER SET utf8 DEFAULT NULL COMMENT '试用期状态：1正常、2结束、3延期、4不录用',
  `ksrq` char(10) CHARACTER SET utf8 DEFAULT NULL COMMENT '试用期开始日期，格式2024-01-01',
  `jsrq` char(10) CHARACTER SET utf8 DEFAULT NULL COMMENT '试用期结束日期，格式2024-04-01',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='员工试用信息表';

#
# Data for table "sy"
#

INSERT INTO `sy` VALUES ('10acc0246122481f9e745b27c12cbb19','f62012e4abde4efc97518129eafee547','2','2021-01-01','2021-04-01'),('385ad1b748214c559dad770165a9109d','8bfd4bbdaf694cfd994605dd1854cf7b','2','2021-01-01','2021-04-01'),('c8e11d99b39044e080d726a7828ae3ae','836f5e22ca7d4e2294abbacfaf2f789e','2','2021-01-01','2021-04-01');

#
# Structure for table "yg"
#

DROP TABLE IF EXISTS `yg`;
CREATE TABLE `yg` (
  `id` char(32) CHARACTER SET utf8 NOT NULL DEFAULT '' COMMENT 'id',
  `bh` char(6) CHARACTER SET utf8 NOT NULL DEFAULT '' COMMENT '编号',
  `xm` varchar(30) CHARACTER SET utf8 DEFAULT NULL COMMENT '姓名',
  `xb` char(1) CHARACTER SET utf8 DEFAULT NULL COMMENT '性别：1男、2女',
  `csrq` char(10) CHARACTER SET utf8 DEFAULT NULL COMMENT '出生日期，格式2000-01-01',
  `bmid` char(32) CHARACTER SET utf8 NOT NULL DEFAULT '' COMMENT '部门id',
  `gwid` char(32) CHARACTER SET utf8 NOT NULL DEFAULT '' COMMENT '岗位id',
  `rzrq` char(10) CHARACTER SET utf8 DEFAULT NULL COMMENT '入职日期，格式2021-01-01',
  `zzzt` char(1) CHARACTER SET utf8 DEFAULT NULL COMMENT '在职状态：1在职、2试用、3离职',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='员工信息表';

#
# Data for table "yg"
#

INSERT INTO `yg` VALUES ('0ba6b693d1fd4fd1a9223645c48c61ed','YG0004','赵云','1','1995-02-09','7b08eb003c474147a7d762ad5fb15246','8f1797eec70d42b3b0781fd83905f3a6','2021-01-01','1'),('3ec0d5c612fa46da963c62cd21a53097','YG0002','关羽','1','1995-02-02','7b08eb003c474147a7d762ad5fb15246','2a356d766c114505857a9351bb318ed3','2021-01-01','1'),('5c9d48960136440b97e518377d9b7e0f','YG0003','张飞','1','1995-02-07','7b08eb003c474147a7d762ad5fb15246','323ff2f7164247288fe8e4955eb47c86','2021-01-01','1'),('836f5e22ca7d4e2294abbacfaf2f789e','YG0008','魏延','1','1995-02-19','880fc4a8a7374ce99ade9b0f38477bd6','80301b0e050548839758a90bdbcb0396','2021-01-01','3'),('8bfd4bbdaf694cfd994605dd1854cf7b','YG0007','廖化','1','1995-02-15','880fc4a8a7374ce99ade9b0f38477bd6','b69418e78da54abea68f6b72a3aed0fc','2021-01-01','1'),('d8238c31965f4ced9c827e55cd0d8bf0','YG0005','马超','1','1995-02-10','7b08eb003c474147a7d762ad5fb15246','8f1797eec70d42b3b0781fd83905f3a6','2021-01-01','1'),('e235cc4e882f4cf692a393890aeed28b','YG0001','刘备','1','1995-01-10','b50fb65031644b36ab930928c2984f61','e163b9964b154e7e94baa3743a7ca60f','2021-01-01','1'),('f62012e4abde4efc97518129eafee547','YG0006','黄忠','1','1995-02-12','880fc4a8a7374ce99ade9b0f38477bd6','abedfcc6cc6d497db33b2ae4f6e207a0','2021-01-01','1');
