(function (ng) {
    var mod = angular.module('usuarioModule', ['ui.router']);
    
    mod.config(['$stateProvider', function ($stateProvider) {
            var basePath = 'src/modules/usuarios/';
            var htmlPath = 'src/modules/html/';
            
            $stateProvider
            .state('usuarioList',{
                url: '/usuarios/todos',
                data: {
                    requireLogin: true,
                    roles: [true]
                },
                views:{
                    'listView':{
                        templateUrl: basePath + '/list/usuarios.list.html',
                        controller: 'usuarioCtrl',
                        controllerAs: 'ctrl'
                    }
                }
            })
            .state('usuarioRegister',{
                url: '/usuario/registro',
                data: {
                    requireLogin: false,
                    roles: []
                },
                views: {
                    'masterView': {
                        templateUrl: basePath + '/register/usuarios.register.html',
                        controller: 'usuariosRegisterCtrl'
                    }
                }
            })
            .state('usuarioRegisterSuccess',{
                url: '/usuario/registro/exitoso',
                param: {
                    usuarioId: null
                },
                data: {
                    requireLogin: true,
                    roles: [false]
                },
                'views': {
                    'masterView':{
                        templateUrl: basePath + '/register/usuarios.register.success.html',
                        controller: 'usuariosRegisterSuccessCtrl'
                    }
                }
            })
            .state('usuarioLogin',{
                url: '/usuario/ingreso',
                data: {
                    requireLogin: false,
                    roles: []
                },
                views: {
                    'masterView':{
                        templateUrl: basePath + '/login/usuarios.login.html',
                        controller: 'usuarioLoginCtrl',
                        controllerAs: 'ctrl'
                    }
                }
            })
            .state('usuarioDetail',{
                url: '/usuario/{usuarioId:int}/informacion',
                data: {
                    requireLogin: false,
                    roles: []
                },
                param: {
                    usuarioId: null
                },
                views: {
                    'masterView':{
                        templateUrl: htmlPath + 'cleanMaster.html'
                    },
                    'listView': {
                        templateUrl: basePath + 'list/usuarios.list.html',
                        controller: 'usuarioCtrl',
                        controllerAs: 'ctrl'
                    },
                    'detailView': {
                        templateUrl: basePath + 'usuario.info.html',
                        controller: 'usuarioCtrl',
                        controllerAs: 'ctrl'
                    }
                }       
            });
        }
    ]);
})(window.angular);

