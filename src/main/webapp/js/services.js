angular.module('moveit.services', ['ngResource'])

.factory('Quotation', function($resource) {
    return $resource('rest/quotation/:id', { id: '@id' });
});
