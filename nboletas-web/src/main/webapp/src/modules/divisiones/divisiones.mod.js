/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

(function (ng) {
    var mod = angular.module("divisionesModule", ['ui.router']);
    mod.config(['$stateProvider', '$urlRouterProvider', function ($stateProvider, $urlRouterProvider) {
            var basePath = 'src/modules/divisiones/';
            $urlRouterProvider.otherwise("/divisiones");
            $stateProvider
                    .state('divisiones', {
                        url: "/divisiones",
                        abstract: true,
                        views: {
                            'mainView':{
                                templateUrl: basePath + 'divisiones.html',
                                controller: 'divisionesCtrl',
                                controllerAs: 'ctrl'
                            }
                        }
                        
                    })
                    .state('divisionesList', {
                        url: '/list',
                        parent: 'divisiones',
                        views:{
                            'listView':{
                                templateUrl: basePath + 'divisiones.list.html'
                            }
                        }
                    })
                    .state('divisionesDetail' ,{
                        url: '/{divisionId:int}/detail',
                        parent: 'divisiones',
                        param: {
                            divisionId: null
                        },
                        
                        views: {
                            'detailView': {
                                templateUrl: basePath + 'divisiones.detail.html',
                                controller: 'divisionesCtrl',
                                controllerAs: 'ctrl'
                            }
                        }
                    })
                    .state('divisionesCreate',{
                        url: '/create',
                        parent: 'divisiones',
                        views: {
                            'detailView': {
                                templateUrl: basePath + '/new/divisiones.new.html',
                                controller: 'divisionesNewCtrl'
                            }
                        }        
                    })
                    .state('divisionesUpdate', {
                        url: '/update/{divisionId:int}',
                        parent: 'divisiones',
                        param: {
                            divisionId: null
                        },
                        views: {
                            'detailView': {
                                templateUrl: basePath + '/update/divisiones.update.html',
                                controller: 'divisionesUpdateCtrl'
                            }
                        }
                    })
                    .state('divisionesDelete',{
                       url: '/delete/{divisionId:int}',
                        parent: 'divisiones',
                        param: {
                            divisionId: null
                        },
                        views: {
                            'detailView': {
                                templateUrl: basePath + '/delete/divisiones.delete.html',
                                controller: 'divisionesDeleteCtrl'
                            }
                        }         
                    });
        }]);
})(window.angular);


