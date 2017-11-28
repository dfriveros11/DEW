/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
(function (ng) {
    var mod = angular.module("mainAppModule", ['ui.router']);
    mod.config(['$stateProvider', '$urlRouterProvider', function ($stateProvider, $urlRouterProvider) {
           $urlRouterProvider.otherwise("");
            $stateProvider
                    .when('', {
                        url: "",
                        views: {
                            'listView':{
                                templateUrl: 'html/main.html'
                            },
                            'miniPostView':{
                                templateUrl: 'html/miniPosts.html'
                            },
                            'postsListView':{
                                templateUrl: 'html/postsList.html'
                            }
                        }
                    });
        }]);
})(window.angular);


