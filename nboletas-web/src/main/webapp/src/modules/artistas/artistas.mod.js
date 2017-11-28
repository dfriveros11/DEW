/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

(function (ng) {
    var mod = angular.module("artistasModule", ['ui.router']);
    mod.config(['$stateProvider', '$urlRouterProvider', function ($stateProvider, $urlRouterProvider) {
            var basePath = 'src/modules/artistas/';
            $urlRouterProvider.otherwise("/artistas");
            $stateProvider
                    .state('artistas', {
                        url: "/artistas",
                        abstract: true,
                        views: {
                            'mainView':{
                                templateUrl: basePath + 'artistas.html',
                                controller: 'artistaCtrl',
                                controllerAs: 'ctrl'
                            }
                        }
                        
                    })
                    .state('artistasList', {
                        url: '/list',
                        views:{
                            'listView':{
                                templateUrl: basePath + 'artistas.list.html'
                            }
                        }
                    })
                    .state('artistaDetail' ,{
                        url: '/{artistaId:int}/detail',
                        parent: 'artistas',
                        param: {
                            artistaId: null
                        },
                        views: {
                            'detailView': {
                                templateUrl: basePath + 'artistas.detail.html',
                                controller: 'artistaCtrl',
                                controllerAs: 'ctrl'
                            }
                        }
                    })
                    .state('artistasCreate',{
                        url: '/create',
                        parent: 'artistas',
                        views: {
                            'detailView': {
                                templateUrl: basePath + '/new/artistas.new.html',
                                controller: 'artistaNewCtrl'
                            }
                        }        
                    })
                    .state('artistaUpdate', {
                        url: '/update/{artistaId:int}',
                        parent: 'artistas',
                        param: {
                            artistaId: null
                        },
                        views: {
                            'detailView': {
                                templateUrl: basePath + '/update/artistas.update.html',
                                controller: 'artistaUpdateCtrl'
                            }
                        }
                    })
                    .state('artistasDelete',{
                       url: '/delete/{artistaId:int}',
                        parent: 'artistas',
                        param: {
                            artistaId: null
                        },
                        views: {
                            'detailView': {
                                templateUrl: basePath + '/delete/artistas.delete.html',
                                controller: 'artistaDeleteCtrl'
                            }
                        }         
                    });
        }]);
})(window.angular);


