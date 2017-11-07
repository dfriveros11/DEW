(function (ng) {
    var app = angular.module('mainApp', [
        // External dependencies
        'ui.router',
        'ui.bootstrap',
        // Internal modules dependencies   
        'boletasModule',
        'organizadoresModule',
        'funcionesModule',
        'espectaculosModule',
        'usuarioModule',
        'espectaculosModule', 
        'artistasModule',
        'lugaresModule',
        'divisionesModule',
        'sillasModule',
        'enviosModule',
        'comentariosModule'
    ]);
    // Resuelve problemas de las promesas
    app.config(['$qProvider', function ($qProvider) {
            $qProvider.errorOnUnhandledRejections(false);
    }]);
})(window.angular);
