const hashFn = require('./modulePathHashFunction')

const str = `__d(function(g,r,i,a,m,e,d){'use strict';var t=r(d[0])('RCTTextInlineImage');m.exports=t},-2130692937,[1230945794]);`

const MODULE_ID_PATTERN = /__d\(.*\},(.*),.*/



console.log(hashFn('/pages/home/index.js'))