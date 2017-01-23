angular.module('myApp',[])
.controller('myController', function($scope, $http) {
	$scope.data = null;
	$scope.getArtistByName = function(input) {
		$http.get('/artists/search/byName?name=' + encodeString(input.toLowerCase()))
		.success(function (data, status, headers, config) {
			$scope.data = angular.fromJson(data);
		})
		.error(function (e) {
			$scope.data = e;
		})
	};
	$scope.getAlbumByName = function(input) {
		$http.get('/albums/search/byName?name=' + encodeString(input.toLowerCase()))
		.success(function (data, status, headers, config) {
			$scope.data = angular.fromJson(data);
		})
		.error(function (e) {
			$scope.data = e;
		})
	};
	$scope.getTrackByName = function(input) {
		$http.get('/tracks/search/byName?name=' + encodeString(input.toLowerCase()))
		.success(function (data, status, headers, config) {
			$scope.data = angular.fromJson(data);
		})
		.error(function (e) {
			$scope.data = e;
		})
	};
	$scope.getArtistById = function(input) {
		$http.get('/artists/search/byId?id=' + input)
		.success(function (data, status, headers, config) {
			$scope.data = angular.fromJson(data);
		})
		.error(function (e) {
			$scope.data = e;
		})
	};
	$scope.getAlbumById = function(input) {
		$http.get('/albums/search/byId?id=' + input)
		.success(function (data, status, headers, config) {
			$scope.data = angular.fromJson(data);
		})
		.error(function (e) {
			$scope.data = e;
		})
	};
	$scope.getTrackById = function(input) {
		$http.get('/tracks/search/byId?id=' + input)
		.success(function (data, status, headers, config) {
			$scope.data = angular.fromJson(data);
		})
		.error(function (e) {
			$scope.data = e;
		})
	};
	$scope.getAlbumByArtistId = function(input) {
		$http.get('/albums/search/byArtist?artist=' + input)
		.success(function (data, status, headers, config) {
			$scope.data = angular.fromJson(data);
		})
		.error(function (e) {
			$scope.data = e;
		})
	};
	$scope.getTrackByAlbumId = function(input) {
		$http.get('/tracks/search/byAlbum?album=' + input)
		.success(function (data, status, headers, config) {
			$scope.data = angular.fromJson(data);
		})
		.error(function (e) {
			$scope.data = e;
		})
	};
	function titleCase(str) {
		return str
		.toLowerCase()
		.split(' ')
		.map(function(word) {
			return word[0].toUpperCase() + word.substr(1);
		})
		.join(' ');
	}

	encodeString = function(str) {
		return encodeURIComponent(str.trim());
	}
});