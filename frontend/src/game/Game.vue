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
        <button type="button" class="btn btn-info big-btn">{{n}}</button>
      </div>
    </div>
  </div>
</template>

<script>

export default {
  name: 'game',
  data: ()=> ({
    guitareString: 'E',
    fret: 0,
    note: 'E',
    notes: ["A", "A#", "B", "C", "C#", "D", "D#", "E", "F", "F#", "G", "G#"]
  }),
  mounted() {
    this.getNewPosition()
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
    }
  }
}
</script>
<
