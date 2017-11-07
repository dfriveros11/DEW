(function (ng) {
    var mod = angular.module('usuarioModule', ['ui.router']);
    
    mod.config(['$stateProvider', '$urlRouterProvider', function ($stateProvider, $urlRouterProvider) {
            var basePath = 'src/modules/usuarios/';
            $urlRouterProvider.otherwise("/usuarios");
            $stateProvider
                
            .state('usuario', {
                url: '/usuarios',
                views: {
                    'mainView': {
                        templateUrl: basePath + 'usuarios.html'
                    }
                }
            })
            .state('usuarioList', {
                url: '/list',
                parent: 'usuario',
                views:{
                    'detailView':{
                        templateUrl: basePath + '/list/usuarios.list.html',
                        controller: 'usuarioCtrl',
                        controllerAs: 'ctrl'
                    }
                }
            })
            .state('usuarioRegister',{
                url: '/register',
                parent: 'usuario',
                views: {
                    'detailView': {
                        templateUrl: basePath + '/register/usuarios.register.html',
                        controller: 'usuariosRegisterCtrl'
                    }
                }
            })
            .state('usuarioRegisterSuccess',{
                url: '/successRegistration',
                parent: 'usuario',
                param: {
                    usuario: null
                },
                'views': {
                    'detailView':{
                        templateUrl: basePath + '/register/usuarios.register.success.html',
                        controller: 'usuariosRegisterSuccessCtrl'
                    }
                }
            })
            .state('usuarioLogin',{
                url: '/login',
                parent: 'usuario',
                views: {
                    'detailView':{
                        templateUrl: basePath + '/login/usuarios.login.html',
                        controller: 'usuarioLoginCtrl',
                        controllerAs: 'ctrl'
                    }
                }
            })
            .state('usuarioDetail',{
                url: '/{usuarioId:int}/info',
                parent: 'usuario',
                param: {
                    usuarioId: null
                },
                views: {
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

