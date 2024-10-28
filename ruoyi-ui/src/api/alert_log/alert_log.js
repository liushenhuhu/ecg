import request from '@/utils/request'

// 查询心电数据列表
export function listAlert_log(query) {
  return request({
    url: '/alert_log/alert_log/list',
    method: 'get',
    params: query
  })
}

// 查询心电数据详细
export function getAlert_log(logId) {
  return request({
    url: '/alert_log/alert_log/' + logId,
    method: 'get'
  })
}

// 新增心电数据
export function addAlert_log(data) {
  return request({
    url: '/alert_log/alert_log',
    method: 'post',
    data: data
  })
}

// 修改心电数据
export function updateAlert_log(data) {
  return request({
    url: '/alert_log/alert_log',
    method: 'put',
    data: data
  })
}

// 删除心电数据
export function delAlert_log(logId) {
  return request({
    url: '/alert_log/alert_log/' + logId,
    method: 'delete'
  })
}
