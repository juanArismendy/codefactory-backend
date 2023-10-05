package com.ssmu.security.domain.use_cases;

 public interface BaseUseCase<I, R> {
  /// Method to be executed by current use case.
  ///
  /// Should be the only public method
  public R call(I data);
}
