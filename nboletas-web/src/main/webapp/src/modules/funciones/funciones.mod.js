/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
(function (ng) {
    var mod = ng.module("funcionesModule", []);
    mod.constant("funcionesContext", "api/funciones");
    mod.config(['$stateProvider', '$urlRouterProvider', function ($stateProvider, $urlRouterProvider) {
            var basePath = 'src/modules/funciones/';
            $urlRouterProvider.otherwise("/funcionesList");

            $stateProvider.state('funcionesList', {
                url: '/list',
                parent: 'funciones',
                views: {
                    'listView': {
                        templateUrl: basePath + 'funciones.list.html',
                        controller: 'funcionesCtrl',
                        controllerAs: 'ctrl'
                    }
                }
            }).state('funciones', {
                url: '/funciones',
                abstract: 'true',
                views: {
                    'mainView': {
                        templateUrl: basePath + 'funciones.html',
                        controller: 'funcionesCtrl',
                        controllerAs: 'ctrl'
                    }
                }
            }).state('funcionesUpdate', {
                url: '/{funcionId:int}/update',
                parent: 'funciones',

                param: {
                    funcionId: null
                },
                views: {
                    'detailView': {
                        templateUrl: basePath + '/update/funciones.update.html',
                        controller: 'funcionesUpdateCtrl'
                    }
                }
            }).state('funcionesDetail', {
                url: '/{funcionId:int}/detail',
                parent: 'funciones',

                param: {
                    funcionId: null
                },
                views: {
                    'detailView': {
                        templateUrl: basePath + 'funciones.detail.html',
                        controller: 'funcionesCtrl',
                        controllerAs: 'ctrl'
                    }
                }
            });
        }]);

})(window.angular);



