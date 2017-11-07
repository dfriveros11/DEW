/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
(function (ng) {
    var mod = ng.module("lugaresModule", []);
    mod.constant("lugaresContext", "api/lugares");
    mod.config(['$stateProvider', '$urlRouterProvider', function ($stateProvider, $urlRouterProvider) {
            var basePath = 'src/modules/lugares/';
            $urlRouterProvider.otherwise("/lugaresList");

            $stateProvider.state('lugaresList', {
                url: '/list',
                parent: 'lugares',
                views: {
                    'listView': {
                        templateUrl: basePath + 'lugares.list.html',
                        controller: 'lugaresCtrl',
                        controllerAs: 'ctrl'
                    }
                }
            }).state('lugares', {
                url: '/lugares',
                abstract: 'true',
                views: {
                    'mainView': {
                        templateUrl: basePath + 'lugares.html',
                        controller: 'lugaresCtrl',
                        controllerAs: 'ctrl'
                    }
                }
            }).state('lugaresUpdate', {
                url: '/update/{lugarId:int}',
                parent: 'lugares',
                param: {
                    lugarId: null
                },
                views: {
                    'detailView': {
                        templateUrl: basePath + '/update/lugares.update.html',
                        controller: 'lugaresUpdateCtrl'
                    }
                }
            }).state('lugaresCreate', {
                url: '/create',
                parent: 'lugares',
                views: {
                    'detailView': {
                        templateUrl: basePath + '/new/lugares.new.html',
                        controller: 'lugaresNewCtrl'
                    }
                }
            }).state('lugaresDelete', {
                url: '/delete/{lugarId:int}',
                parent: 'lugares',
                
                param: {
                    funcionId: null
                },
                views: {
                    'detailView': {
                        templateUrl: basePath + '/delete/lugares.delete.html',
                        controller: 'lugaresDeleteCtrl'
                    }
                }
            }).state('lugaresDetail', {
                url: '/{lugarId:int}/detail',
                parent: 'lugares',

                param: {
                    funcionId: null
                },
                views: {
                    'detailView': {
                        templateUrl: basePath + 'lugares.detail.html',
                        controller: 'lugaresCtrl',
                        controllerAs: 'ctrl'
                    },
                    'listView': {
                        templateUrl: basePath + 'lugares.list.html',
                        controller: 'lugaresCtrl',
                        controllerAs: 'ctrl'
                    }
                }
            });
        }]);
})(window.angular);



