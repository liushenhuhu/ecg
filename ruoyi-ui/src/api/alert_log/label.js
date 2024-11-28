//读取数据
export function getLabel(data) {
  return request({
    url: '/ecgData/put12BeatLabel',
    method: 'post',
    data: data
  })
}

//提交数据
export function put12BeatLabel(data) {
  return request({
    url: '/ecgData/put12BeatLabel',
    method: 'post',
    data: data
  })
}


export function put12WaveLabel(data) {
  return request({
    url: '/ecgData/put12WaveLabel',
    method: 'post',
    data: data
  })
}
