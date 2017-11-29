/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

(function (ng) {
    var mod = angular.module("artistasModule", ['ui.router']);
    mod.config(['$stateProvider', '$urlRouterProvider', function ($stateProvider, $urlRouterProvider) {
            var basePath = 'src/modules/artistas/';
            var basePathHtml = 'src/modules/'
            $urlRouterProvider.otherwise("/artistasList");
            $stateProvider
                    .state('artistasList', {
                        url: '/artistas/list',
                        views:{
                            'listView':{
                                templateUrl: basePath + 'artistas.list.html',
                                controller: 'artistaCtrl'
                            }
                        }
                    })
                    .state('artistaDetail' ,{
                        url: '/artistas/{artistaId:int}/detail',
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
                        url: '/artistas/create',
                        views: {
                            'detailView': {
                                templateUrl: basePath + '/new/artistas.new.html',
                                controller: 'artistaNewCtrl'
                            }
                        }        
                    })
                    .state('artistaUpdate', {
                        url: '/artistas/update/{artistaId:int}',
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
                       url: '/artistas/delete/{artistaId:int}',
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


