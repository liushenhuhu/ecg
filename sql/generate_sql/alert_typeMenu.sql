-- 菜单 SQL
insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('alert_type', '3', '1', 'alert_type', 'alert_type/alert_type/index', 1, 0, 'C', '0', '0', 'alert_type:alert_type:list', '#', 'admin', sysdate(), '', null, 'alert_type菜单');

-- 按钮父菜单ID
SELECT @parentId := LAST_INSERT_ID();

-- 按钮 SQL
insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('alert_type查询', @parentId, '1',  '#', '', 1, 0, 'F', '0', '0', 'alert_type:alert_type:query',        '#', 'admin', sysdate(), '', null, '');

insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('alert_type新增', @parentId, '2',  '#', '', 1, 0, 'F', '0', '0', 'alert_type:alert_type:add',          '#', 'admin', sysdate(), '', null, '');

insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('alert_type修改', @parentId, '3',  '#', '', 1, 0, 'F', '0', '0', 'alert_type:alert_type:edit',         '#', 'admin', sysdate(), '', null, '');

insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('alert_type删除', @parentId, '4',  '#', '', 1, 0, 'F', '0', '0', 'alert_type:alert_type:remove',       '#', 'admin', sysdate(), '', null, '');

insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('alert_type导出', @parentId, '5',  '#', '', 1, 0, 'F', '0', '0', 'alert_type:alert_type:export',       '#', 'admin', sysdate(), '', null, '');