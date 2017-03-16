import Vue from 'vue'
import VueResource from 'vue-resource'
import App from './App.vue'
import "font-awesome-sass-loader"

Vue.use(VueResource)

export const bus = new Vue()

new Vue({
  el: '#app',
  render: h => h(App),
  created: () => {
	  console.log('Initialize application');
  }
})
