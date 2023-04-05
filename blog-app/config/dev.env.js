'use strict'
const merge = require('webpack-merge')
const prodEnv = require('./prod.env')

module.exports = merge(prodEnv, {
  NODE_ENV: '"development"',
  //修改IP地址、端口号
  BASE_API: '"http://localhost:8888/"'
})
