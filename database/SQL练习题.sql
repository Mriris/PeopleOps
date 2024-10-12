-- # 查询所有部门的编号、名称、电话、传真、成立日期，按照编号升序排序
select bh, mc, dh, cz, clrq
from bm
order by bh;

-- # 查询所有岗位的编号、名称、类型，按照编号升序排序
select bh, mc, lx
from gw
order by bh;

SELECT bh,
       mc,
       CASE
           WHEN lx = 1 THEN '经理'
           WHEN lx = 2 THEN '主管'
           WHEN lx = 3 THEN '专员'
           ELSE '其他'
           END AS 类型
FROM gw
ORDER BY bh;

-- # 查询类型为“经理”的岗位的编号、名称、类型，按照编号升序排序
SELECT bh, mc, lx
FROM gw
WHERE lx = 1
ORDER BY bh;

-- # 查询类型为“经理”或“主管”的岗位的编号、名称、类型，按照编号升序排序
SELECT bh, mc, lx
FROM gw
WHERE lx = 1
   OR lx = 2
ORDER BY bh;

-- # 分页查询所有岗位的编号、名称、类型，按照编号升序排序，每页显示10条，查询第1页
select bh, mc, lx
from gw
order by bh
limit 0,10;

-- # 分页查询所有岗位的编号、名称、类型，按照编号升序排序，每页显示10条，查询第2页
select bh, mc, lx
from gw
order by bh
limit 10,10;


-- # 分页查询所有岗位的编号、名称、类型，按照编号升序排序，每页显示10条，查询第3页
select bh, mc, lx
from gw
order by bh
limit 20,10;


-- # 统计所有岗位的数量
select count(1)
from gw;

-- # 增加一个岗位，id为“c84a7487c9104c8585558741abd54c03”，编号为“GW024”，名称为“销售专员”，类型为“专员”
insert into gw(id, bh, mc, lx)
values ('c84a7487c9104c8585558741abd54c03', 'GW024', '销售专员', '3');

-- # 删除一个岗位，id为“c84a7487c9104c8585558741abd54c03”
delete
from gw
where id = 'c84a7487c9104c8585558741abd54c03';

-- # 修改id为“8bfd4bbdaf694cfd994605dd1854cf7b”的员工信息，将其姓名改为“姜维”，出生日期改为“1995-02-17”
update yg
set xm='姜维',
    csrq='1995-02-17'
where id = '8bfd4bbdaf694cfd994605dd1854cf7b';

-- # 查询所有员工的编号、姓名、性别、出生日期，按照编号升序排序
select bh, xm, xb, csrq
from yg
order by bh;

-- # 分页查询所有员工的编号、姓名、性别、出生日期，按照编号升序排序，每页显示5条，查询第1页
select bh, xm, xb, csrq
from yg
order by bh
limit 0,5;

SELECT bh,
       xm,
       CASE
           WHEN xb = 1 THEN '男'
           WHEN xb = 2 THEN '女'
           ELSE '未知'
           END AS 性别,
       csrq
FROM yg
ORDER BY bh
LIMIT 0, 5;


-- # 查询所有员工的编号、姓名、性别、部门名称，按照员工编号升序排序
SELECT yg.bh, yg.xm, yg.xb, bm.mc
FROM yg
         JOIN bm ON yg.bmid = bm.id
ORDER BY yg.bh;


-- # 查询所有员工的编号、姓名、性别、岗位名称，按照员工编号升序排序
SELECT yg.bh, yg.xm, yg.xb, gw.mc
FROM yg
         JOIN gw ON yg.gwid = gw.id
ORDER BY yg.bh;


-- # 查询所有员工的编号、姓名、性别、部门名称、岗位名称，按照员工编号升序排序
SELECT yg.bh, yg.xm, yg.xb, bm.mc, gw.mc
FROM yg,
     bm,
     gw
WHERE yg.bmid = bm.id
  AND yg.gwid = gw.id
ORDER BY yg.bh;


-- # 分页查询所有员工的编号、姓名、性别、部门名称、岗位名称，按照员工编号升序排序，每页显示5条，查询第1页
SELECT yg.bh, yg.xm, yg.xb, bm.mc, gw.mc
FROM yg,
     bm,
     gw
WHERE yg.bmid = bm.id
  AND yg.gwid = gw.id
ORDER BY yg.bh
limit 0,5;


-- # 查询id为“24c599e7d1fb4dacaa85cf9003bb80f2”的员工的编号、姓名、性别、部门名称、岗位名称
SELECT yg.bh, yg.xm, yg.xb, bm.mc, gw.mc
FROM yg,
     bm,
     gw
WHERE yg.id = 'F5'
  AND yg.bmid = bm.id
  AND yg.gwid = gw.id
ORDER BY yg.bh;


# 查询离职员工的编号、姓名、性别
# SELECT bh, xm, xb
# FROM yg,lz
# WHERE yg.id = lz.ygid AND lzlx = 1;
