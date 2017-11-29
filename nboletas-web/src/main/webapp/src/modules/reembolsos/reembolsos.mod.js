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
                    .state('reembolsosList', {
                        url: '/list',
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
                        views: {
                            'detailView': {
                                templateUrl: basePath + '/new/reembolsos.new.html',
                                controller: 'reembolsoNewCtrl'
                            }
                        }        
                    })
                    .state('reembolsoUpdate', {
                        url: '/update/{reembolsoId:int}',
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

