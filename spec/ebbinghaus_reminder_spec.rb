require_relative '../lib/ebbinghaus_reminder'

describe 'Ebbinghaus Reminder' do
  before(:each) do
    @reminder = EbbinghausReminder.new("2014-04-01")
  end

  context 'when listing dates to be reviewed' do
    it 'should contain today' do
      expect(@reminder.dates_to_be_reviewed).to include("2014-04-01")
    end

    it 'should contain yesterday' do
      expect(@reminder.dates_to_be_reviewed).to include("2014-03-31")
    end

    it 'should contain the day before yesterday' do
      expect(@reminder.dates_to_be_reviewed).to include("2014-03-30")
    end

    it 'should contain 4 days before' do
      expect(@reminder.dates_to_be_reviewed).to include("2014-03-28")
    end

    it 'should contain 7 days before' do
      expect(@reminder.dates_to_be_reviewed).to include("2014-03-25")
    end

    it 'should contain 15 days before' do
      expect(@reminder.dates_to_be_reviewed).to include("2014-03-17")
    end
  end
  context 'when listing random dates to be reviewed' do

    it 'should contain a random day between the date given and 15 days ago' do
      expect(@reminder.random_dates_to_be_reviewed_after("2014-03-16")).to include("2014-03-16")
    end
  end
end