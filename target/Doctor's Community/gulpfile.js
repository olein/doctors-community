var gulp = require('gulp'),
	less = require('gulp-less'),
	watch = require('gulp-watch'),
	path = require('path');

var src = './assets/css/**/*.less',
	build = './assets/css';

gulp.task('less', function () {
  gulp.src(src)
    .pipe(watch(src))
    .pipe(less())
    .pipe(gulp.dest(build));
});