-- 菜单 SQL
insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('心电数据', '3', '1', 'alert_log', 'alert_log/alert_log/index', 1, 0, 'C', '0', '0', 'alert_log:alert_log:list', '#', 'admin', sysdate(), '', null, '心电数据菜单');

-- 按钮父菜单ID
SELECT @parentId := LAST_INSERT_ID();

-- 按钮 SQL
insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('心电数据查询', @parentId, '1',  '#', '', 1, 0, 'F', '0', '0', 'alert_log:alert_log:query',        '#', 'admin', sysdate(), '', null, '');

insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('心电数据新增', @parentId, '2',  '#', '', 1, 0, 'F', '0', '0', 'alert_log:alert_log:add',          '#', 'admin', sysdate(), '', null, '');

insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('心电数据修改', @parentId, '3',  '#', '', 1, 0, 'F', '0', '0', 'alert_log:alert_log:edit',         '#', 'admin', sysdate(), '', null, '');

insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('心电数据删除', @parentId, '4',  '#', '', 1, 0, 'F', '0', '0', 'alert_log:alert_log:remove',       '#', 'admin', sysdate(), '', null, '');

insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('心电数据导出', @parentId, '5',  '#', '', 1, 0, 'F', '0', '0', 'alert_log:alert_log:export',       '#', 'admin', sysdate(), '', null, '');