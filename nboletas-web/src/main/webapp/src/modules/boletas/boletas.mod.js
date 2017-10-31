/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

(function (ng) {
    var mod = angular.module("boletasModule", ['ui.router']);
    mod.config(['$stateProvider', '$urlRouterProvider', function ($stateProvider, $urlRouterProvider) {
            var basePath = 'src/modules/boletas/';
            $urlRouterProvider.otherwise("/boletas");
            $stateProvider
                    .state('boletas', {
                        url: "/boletas",
                        abstract: true,
                        views: {
                            'mainView':{
                                templateUrl: basePath + 'boletas.html',
                                controller: 'boletaCtrl',
                                controllerAs: 'ctrl'
                            }
                        }
                        
                    })
                    .state('boletasList', {
                        url: '/list',
                        parent: 'boletas',
                        views:{
                            'listView':{
                                templateUrl: basePath + 'boletas.list.html'
                            }
                        }
                    })
                    .state('boletaDetail' ,{
                        url: '/{boletaId:int}/detail',
                        parent: 'boletas',
                        param: {
                            boletaId: null
                        },
                        views: {
                            'detailView': {
                                templateUrl: basePath + 'boletas.detail.html',
                                controller: 'boletaCtrl',
                                controllerAs: 'ctrl'
                            }
                        }
                    })
                    .state('boletasCreate',{
                        url: '/create',
                        parent: 'boletas',
                        views: {
                            'detailView': {
                                templateUrl: basePath + '/new/boletas.new.html',
                                controller: 'boletaNewCtrl'
                            }
                        }        
                    })
                    .state('boletaUpdate', {
                        url: '/update/{boletaId:int}',
                        parent: 'boletas',
                        param: {
                            boletaId: null
                        },
                        views: {
                            'detailView': {
                                templateUrl: basePath + '/update/boletas.update.html',
                                controller: 'boletaUpdateCtrl'
                            }
                        }
                    })
                    .state('boletaDelete',{
                       url: '/delete/{boletaId:int}',
                        parent: 'boletas',
                        param: {
                            boletaId: null
                        },
                        views: {
                            'detailView': {
                                templateUrl: basePath + '/delete/boletas.delete.html',
                                controller: 'boletaDeleteCtrl'
                            }
                        }         
                    });
        }]);
})(window.angular);


