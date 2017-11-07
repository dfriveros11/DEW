/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

(function (ng) {
    var mod = angular.module("reembolsosModule", ['ui.router']);

    mod.config(['$stateProvider', '$urlRouterProvider', function ($stateProvider, $urlRouterProvider) {
            var basePath = 'src/modules/reembolsos/';
            $urlRouterProvider.otherwise("/reembolsos");
            $stateProvider
                    .state('reembolsos', {
                        url: "/reembolsos",
                        views: {
                            'mainView':{
                                templateUrl: basePath + 'reembolsos.html'
                            }
                        }
                    })
                    .state('reembolsosList', {
                        url: '/list',
                        parent: 'reembolsos',
                        views:{
                            'listView':{
                                templateUrl: basePath + 'reembolsos.list.html',
                                controller: 'reembolsoCtrl',
                                controllerAs: 'ctrl'
                            }
                        }
                    })
                    .state('reembolsoDetail',{
                        url: '/{reembolsoId:int}/detail',
                        parent: 'reembolsos',
                        param: {
                            reembolsoId: null
                        },
                        views: {
                           
                            'detailView': {
                                templateUrl: basePath + 'reembolsos.detail.html',
                                controller: 'reembolsoCtrl',
                                controllerAs: 'ctrl'
                            }
                        }       
                    })
                    .state('reembolsosCreate',{
                        url: '/create',
                        parent: 'reembolsos',
                        views: {
                            'detailView': {
                                templateUrl: basePath + '/new/reembolsos.new.html',
                                controller: 'reembolsoNewCtrl'
                            }
                        }        
                    })
                    .state('reembolsoUpdate', {
                        url: '/update/{reembolsoId:int}',
                        parent: 'reembolsos',
                        param: {
                            reembolsoId: null
                        },
                        views: {
                            'detailView': {
                                templateUrl: basePath + '/update/reembolsos.update.html',
                                controller: 'reembolsoUpdateCtrl'
                            }
                        }
                    })
                    .state('reembolsoDelete',{
                       url: '/delete/{reembolsoId:int}',
                        parent: 'reembolsos',
                        param: {
                            reembolsoId: null
                        },
                        views: {
                            'detailView': {
                                templateUrl: basePath + '/delete/reembolsos.delete.html',
                                controller: 'reembolsoDeleteCtrl'
                            }
                        }         
                    });
        }]);
})(window.angular);

