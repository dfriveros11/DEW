/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
(function (ng) {
    var mod = ng.module("enviosModule");
    mod.constant("enviosContext", "api/envios");
    mod.filter('yesNo', function() {
        return function(value) {
        if (value === true) {
            return 'Yes';
        } else if (value === false) {
            return 'No';
        } else {
            return '';
        }
        };
    }); 
    mod.controller('envioCtrlFilter', ['$scope', '$http', 'enviosContext',
        function ($scope, $http, enviosContext) {
            
        }
    ]);
}
)(window.angular);

