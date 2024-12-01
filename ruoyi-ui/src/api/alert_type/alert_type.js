import request from '@/utils/request'

// 查询alert_type列表
export function listAlert_type(query) {
  return request({
    url: '/alert_type/alert_type/list',
    method: 'get',
    params: query
  })
}

// 查询alert_type详细
export function getAlert_type(id) {
  return request({
    url: '/alert_type/alert_type/' + id,
    method: 'get'
  })
}

// 新增alert_type
export function addAlert_type(data) {
  return request({
    url: '/alert_type/alert_type',
    method: 'post',
    data: data
  })
}

// 修改alert_type
export function updateAlert_type(data) {
  return request({
    url: '/alert_type/alert_type',
    method: 'put',
    data: data
  })
}

// 删除alert_type
export function delAlert_type(id) {
  return request({
    url: '/alert_type/alert_type/' + id,
    method: 'delete'
  })
}
