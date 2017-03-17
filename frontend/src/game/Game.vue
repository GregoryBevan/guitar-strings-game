<template>
  <div class="container">
    <div class="row col-xs-12">
      <div class="col-xs-6 text-center">
        <h2><strong>Corde</strong></h2>
        <div>
          <span class="note">{{ guitareString }}</span>
        </div>
      </div>
      <div class="col-xs-6 text-center">
        <h2><strong>Case</strong></h2>
        <div class="">
          <span class="note">{{ fret}}</span>
        </div>
      </div>
    </div>
    <div class="row col-xs-12 space"></div>
    <div class="row col-xs-12 form-group">
      <div class="col-xs-1" v-for="n in notes">
        <button type="button" class="btn big-btn" v-bind:class="{'btn-info': selectedNote == '' || !(n == note),'btn-success': n == note, 'btn-danger': selectedNote == n && n != note}" v-on:click="checkResponse(n, $event)">{{n}}</button>
      </div>
    </div>
    <div class="row col-xs-12 text-center" v-bind:class="{'mask': selectedNote == ''}">
        <br><br>
        <button type="button" class="btn btn-primary" v-on:click="reload">Recommencer</button>
    </div>
  </div>
</template>

<script>
import _ from 'lodash'

export default {
  name: 'game',
  data: ()=> ({
    guitareString: '',
    fret: 0,
    note: '',
    sortedNotes: ["A", "A#", "B", "C", "C#", "D", "D#", "E", "F", "F#", "G", "G#"],
    notes: [],
    selectedNote: ''
  }),
  mounted() {
    this.getNewPosition();
    this.notes = _.shuffle(this.sortedNotes);
  },
  methods: {
    getNewPosition: function() {
      this.$http.get('game/new-position').then((response) => {
        console.log(response);
        var data = response.body;
        this.guitareString = data.guitarString;
        this.fret = data.fret;
        this.note = data.note;
      })
    },
    checkResponse: function(note, event) {
      this.selectedNote = note;
    },
    reload: function() {
      this.selectedNote = '';
      this.getNewPosition();
    }
  }
}
</script>
