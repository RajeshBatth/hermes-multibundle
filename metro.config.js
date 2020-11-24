const modulePathHashFunction = require('./modulePathHashFunction')
module.exports = {
    serializer: {
        createModuleIdFactory: function () {
            return function (path) {
                return modulePathHashFunction(path)
            }
        }
    }
}