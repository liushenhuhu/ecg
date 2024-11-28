-- 菜单 SQL
insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('静态12导心电数据', '0', '1', 'Jecg12', 'Jecg12/Jecg12/index', 1, 0, 'C', '0', '0', 'Jecg12:Jecg12:list', '#', 'admin', sysdate(), '', null, '静态12导心电数据菜单');

-- 按钮父菜单ID
SELECT @parentId := LAST_INSERT_ID();

-- 按钮 SQL
insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('静态12导心电数据查询', @parentId, '1',  '#', '', 1, 0, 'F', '0', '0', 'Jecg12:Jecg12:query',        '#', 'admin', sysdate(), '', null, '');

insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('静态12导心电数据新增', @parentId, '2',  '#', '', 1, 0, 'F', '0', '0', 'Jecg12:Jecg12:add',          '#', 'admin', sysdate(), '', null, '');

insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('静态12导心电数据修改', @parentId, '3',  '#', '', 1, 0, 'F', '0', '0', 'Jecg12:Jecg12:edit',         '#', 'admin', sysdate(), '', null, '');

insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('静态12导心电数据删除', @parentId, '4',  '#', '', 1, 0, 'F', '0', '0', 'Jecg12:Jecg12:remove',       '#', 'admin', sysdate(), '', null, '');

insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('静态12导心电数据导出', @parentId, '5',  '#', '', 1, 0, 'F', '0', '0', 'Jecg12:Jecg12:export',       '#', 'admin', sysdate(), '', null, '');