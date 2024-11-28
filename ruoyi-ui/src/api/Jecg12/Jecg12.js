import request from '@/utils/request'

// 查询静态12导心电数据列表
export function listJecg12(query) {
  return request({
    url: '/Jecg12/Jecg12/list',
    method: 'get',
    params: query
  })
}

// 查询静态12导心电数据详细
export function getJecg12(pId) {
  return request({
    url: '/Jecg12/Jecg12/' + pId,
    method: 'get'
  })
}

// 新增静态12导心电数据
export function addJecg12(data) {
  return request({
    url: '/Jecg12/Jecg12',
    method: 'post',
    data: data
  })
}

// 修改静态12导心电数据
export function updateJecg12(data) {
  return request({
    url: '/Jecg12/Jecg12',
    method: 'put',
    data: data
  })
}

// 删除静态12导心电数据
export function delJecg12(pId) {
  return request({
    url: '/Jecg12/Jecg12/' + pId,
    method: 'delete'
  })
}
