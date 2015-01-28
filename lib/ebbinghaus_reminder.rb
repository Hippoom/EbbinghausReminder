require 'date'

class EbbinghausReminder


  def initialize today_str
    @today = to_date today_str
  end

  def self.today
    EbbinghausReminder.new(DateTime.now.strftime('%Y-%m-%d'))
  end

  def self.today_is str
    EbbinghausReminder.new(str)
  end

  def dates_to_be_reviewed
    [0, 1, 2, 4, 7, 15].map { |days| @today - days }.map do |date|
      date.to_str
    end
  end

  def random_dates_to_be_reviewed_after start
    [(fifteen_days_before - Random.rand(1..fifteen_days_before - to_date(start))).to_str]
  end

  def fifteen_days_before
    @today - 15
  end

  def to_date(str)
    DateTime.strptime(str, '%Y-%m-%d')
  end

  private :to_date
end

class DateTime
  def to_str
    self.strftime('%Y-%m-%d')
  end
end