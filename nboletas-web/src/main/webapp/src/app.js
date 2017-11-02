(function (ng) {
    var app = angular.module('mainApp', [
        // External dependencies
        'ui.router',
        'ui.bootstrap',
        'boletasModule',
        'organizadoresModule',
        'funcionesModule',
        'espectaculosModule',
        'usuarioModule'
        // Internal modules dependencies   
    ]);
    // Resuelve problemas de las promesas
    app.config(['$qProvider', function ($qProvider) {
            $qProvider.errorOnUnhandledRejections(false);
        }]);
})(window.angular);
