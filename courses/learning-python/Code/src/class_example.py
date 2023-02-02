class MusicInstrument:
    def __init__(self, instrument_type):
        self.instrument_type = instrument_type


class Bass(MusicInstrument):
    def __init__(self, bass_type):
        super().__init__("Bass")
        self.bass_type = bass_type
        self.number_strings = 4


new_instrument = MusicInstrument("Bass")
print(new_instrument.instrument_type)

new_bass = Bass("Electric")
print(new_bass.instrument_type, new_bass.bass_type, new_bass.number_strings)
